package otl;

public interface EditToken {
    static String toString(Object value) {
        if (value instanceof Boolean b) return b ? "ㅇㅇ" : "ㄴㄴ";
        else return value.toString();
    }
}
