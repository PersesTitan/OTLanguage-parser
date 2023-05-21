package otl;

import com.intellij.psi.PsiElement;
import com.otl.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;

public interface EditToken {
    static String toString(Object value) {
        if (value instanceof Boolean b) return b ? "ㅇㅇ" : "ㄴㄴ";
        else return value.toString();
    }

    default String getType(@NotNull PsiElement element) {
        if (element instanceof OtlDefineKlass) return "OTLanguage define class";
        else if (element instanceof OtlDefineMethod) return "OTLanguage define method";
        else if (element instanceof OtlCreateVariable) return "OTLanguage create variable";
        else if (element instanceof OtlUpdateVariable) return "OTLanguage update variable";
        else if (element instanceof OtlRemarkToken) return "OTLanguage remark";
        else return "";
    }

    default String getName(@NotNull PsiElement element) {
        if (element instanceof OtlKlassKey item) return item.getName();
        else if (element instanceof OtlMethodKey item) return item.getName();
        else if (element instanceof OtlVariableKey item) return item.getName();
        else return "";
    }

    default String getText(@NotNull PsiElement element) {
        if (element instanceof OtlDefineKlass item) return item.getText();
        else if (element instanceof OtlDefineMethod item) return item.getText();
        else if (element instanceof OtlCreateVariable item) return item.getText();
        else if (element instanceof OtlUpdateVariable item) return item.getText();
        else if (element instanceof OtlRemarkToken item) return item.getText();
        else return "";
    }
}
