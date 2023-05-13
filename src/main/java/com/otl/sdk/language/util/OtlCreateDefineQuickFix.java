package com.otl.sdk.language.util;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.codeInspection.util.IntentionName;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.IncorrectOperationException;
import com.otl.sdk.language.OtlFileType;
import com.otl.sdk.language.element.OtlElementFactory;
import com.otl.sdk.language.psi.OtlDefineKlass;
import com.otl.sdk.language.psi.OtlFile;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public class OtlCreateDefineQuickFix extends BaseIntentionAction {
    private final String key;

    public OtlCreateDefineQuickFix(String key) {
        this.key = key;
    }

    @Override
    public @IntentionName @NotNull String getText() {
        return "Create class '" + key + "'";
    }

    @Override
    public @NotNull @IntentionFamilyName String getFamilyName() {
        return "Create class";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return true;
    }

    @Override
    public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(() -> {
            Collection<VirtualFile> virtualFiles =
                    FileTypeIndex.getFiles(OtlFileType.INSTANCE, GlobalSearchScope.allScope(project));
            if (virtualFiles.size() == 1) create(project, virtualFiles.iterator().next());
            else {
                FileChooserDescriptor descriptor =
                        FileChooserDescriptorFactory.createSingleFileDescriptor(OtlFileType.INSTANCE);
                descriptor.setRoots(ProjectUtil.guessProjectDir(project));
                VirtualFile f = FileChooser.chooseFile(descriptor, project, null);
                if (f != null) create(project, f);
            }
        });
    }

    private void create(Project project, VirtualFile file) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            OtlFile otlFile = (OtlFile) PsiManager.getInstance(project).findFile(file);
            assert otlFile != null;
            ASTNode lastChildNode = otlFile.getNode().getLastChildNode();
            if (lastChildNode != null) otlFile.getNode().addChild(OtlElementFactory.createCRLF(project).getNode());
            OtlDefineKlass otlDefineKlass = OtlElementFactory.createKlass(project, key, "");
            otlFile.getNode().addChild(otlDefineKlass.getNode());
            ((Navigatable) otlDefineKlass.getLastChild().getNavigationElement()).navigate(true);
            Objects.requireNonNull(FileEditorManager.getInstance(project).getSelectedTextEditor())
                    .getCaretModel()
                    .moveCaretRelatively(2, 0, false, false, false);
        });
    }
}
