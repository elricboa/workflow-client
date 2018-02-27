package fun.elricboa.enums;

/**
 * 流程状态
 */
public enum ProcessStatus {

    NOT_START(0, "未开始"),
    SUCCESS(2, "已审核");

    private final int value;
    private final String name;

    ProcessStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
