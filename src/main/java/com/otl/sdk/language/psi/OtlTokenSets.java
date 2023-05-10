package com.otl.sdk.language.psi;

import com.intellij.psi.tree.TokenSet;
import com.otl.sdk.language.OtlTypes;

public interface OtlTokenSets {
    TokenSet KLASS_IDENTIFIER = TokenSet.create(OtlTypes.KLASS_IDENTIFIER);
    TokenSet METHOD_IDENTIFIER = TokenSet.create(OtlTypes.METHOD_IDENTIFIER);
    TokenSet VARIABLE_IDENTIFIER = TokenSet.create(OtlTypes.VARIABLE_IDENTIFIER);
    TokenSet REMARK = TokenSet.create(OtlTypes.REMARK);
}
