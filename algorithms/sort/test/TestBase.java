package sort.test;

public class TestBase {
    public static void test(String title, int[] expect, int[] received) {
        printTestHeader(title);
        var result = compare(expect, received);
        printList("Expect", Color.GREEN, expect);
        printResult(result);
    }

    private static void printResult(TestResult result) {
        StringBuilder formetedResult = new StringBuilder();
        var color = result.passed() ? Color.GREEN : Color.RED;
        formetedResult.append(String.format("\u001b[%d;1m %-20s\u001b[0m ", color.getValue(), "Received"));

        for (Comparabled listItem : result.resultData()) {
            appenToResult(formetedResult, listItem);
        }

        formetedResult.delete(formetedResult.length() - 2, formetedResult.length() - 1);
        formetedResult.append("\n");
        System.out.println(formetedResult);
    }

    private static void appenToResult(StringBuilder formetedResult, Comparabled listItem) {
        if (listItem.isEqual()) {
            formetedResult.append(listItem.value() + ", ");
            return;
        }

        formetedResult.append(String.format("\u001b[%d;1m %s \u001b[0m, ", Color.RED.getValue(), listItem.value()));
    }

    private static TestResult compare(int[] listOne, int[] listTwo) {
        var resultData = new Comparabled[listOne.length];
        var passed = true;

        for (int i = 0; i < listOne.length; i++) {
            var isEqual = listOne[i] == listTwo[i];
            passed = passed && isEqual;
            resultData[i] = new Comparabled(isEqual, listTwo[i]);
        }

        return new TestResult(passed, resultData);
    }

    private static void printList(String prefix, Color color, int[] list) {
        StringBuilder formetedPrefix = new StringBuilder();
        formetedPrefix.append(String.format("\u001b[%d;1m %-20s\u001b[0m ", color.getValue(), prefix));

        for (int listItem : list) {
            formetedPrefix.append(listItem + ", ");
        }

        formetedPrefix.delete(formetedPrefix.length() - 2, formetedPrefix.length() - 1);
        formetedPrefix.append("\n");
        System.out.println(formetedPrefix);
    }

    private static void printTestHeader(String name) {
        var spaceTocenter = (60 - (name.length() / 2));
        var format = "\n\n\u001b[%d;1m%" + spaceTocenter + "s%s%" + spaceTocenter + "s\u001b[0m\n";
        var testHeader = String.format(format, Color.BLUE.getValue(), " ", name, " ");
        System.out.println(testHeader);
    }
}

final record TestResult(boolean passed, Comparabled[] resultData) {
};

final record Comparabled(boolean isEqual, int value) {
}

final record TestLists(
        int[] any,
        int[] alreadySorted,
        int[] inversedSorted,
        int[] repeadted) {
}

enum Color {
    GREEN(42),
    RED(41),
    BLUE(44);

    private int value;

    Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}