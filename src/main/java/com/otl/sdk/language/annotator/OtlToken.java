package com.otl.sdk.language.annotator;

import java.util.Set;

public interface OtlToken {
    Set<Character> BLANKS = Set.of(' ', '\t', '\f');

    char PARAM_S = '[';
    String KLASS = "ㅋㅅㅋ";
    String METHOD = "ㅁㅅㅁ";

    Set<String> ORIGIN_TYPE = Set.of(
            "ㅇㅈㅇ", "ㅇㅉㅇ", "ㅇㅂㅇ", "ㅇㅁㅇ", "ㅇㄱㅇ", "ㅇㅅㅇ", "ㅇㅆㅇ",
            "ㄴㅈㄴ", "ㄴㅉㄴ", "ㄴㅂㄴ", "ㄴㅁㄴ", "ㄴㄱㄴ", "ㄴㅅㄴ", "ㄴㅆㄴ",
            "ㄹㅈㄹ", "ㄹㅉㄹ", "ㄹㅂㄹ", "ㄹㅁㄹ", "ㄹㄱㄹ", "ㄹㅅㄹ", "ㄹㅆㄹ",
            "ㅈㅈㅈ", "ㅈㅉㅈ", "ㅈㅂㅈ", "ㅈㅁㅈ", "ㅈㄱㅈ", "ㅈㅅㅈ", "ㅈㅆㅈ"
    );
}
