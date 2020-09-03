package com.baron.c04_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    String expression;

    public ReversePolishNotation(String expression) {
        this.expression = expression;
    }

    public static void main(String[] args) throws Exception {

        ReversePolishNotation notation = new ReversePolishNotation("");

        List<String> list = new ArrayList<>();

        // (3+4) * 5-6
        // 3+4 * 5-6
//        list.add("(");
        list.add("3");
        list.add("+");
        list.add("4");
//        list.add(")");
        list.add("*");
        list.add("5");
        list.add("-");
        list.add("6");

        List<String> notation2 = notation.toReversePolishNotation2(list);

        System.out.println(notation2);

        int result = notation.calculate(notation2);

        System.out.println(result);
//        System.out.println(notation.calculate(notation2));

//        String expression = "3 4 + 5 * 6 -";
//
//        ReversePolishNotation notation = new ReversePolishNotation(expression);
//
//        List<String> list = notation.toList();
//
//        System.out.println(notation.calculate(list));
    }

    public List<String> toList() {
        String[] split = expression.split(" ");

        return new ArrayList<>(Arrays.asList(split));
    }

    /**
     * 根据后序表达式进行计算
     * 1. 从左至右，将3和4压入栈中
     * 2. 遇到+运算符，因此弹出4和3，计算出3+4的值，得7，再将7入栈
     * 3. 将5入栈
     * 4. 接下来是x运算符，因此弹出5和7，计算出5x7=35，将35入栈
     * 5. 将6入栈
     * 6. 最后是-运算符，计算出35-6的值，得29，由此得出最终结果
     */
    public int calculate(List<String> list) throws Exception {
        Stack<String> stack = new Stack<>();
        int result;

        for ( String item : list ) {
            // 如果是数字，直接将其压入栈中(正则表达曾写错)
            if (item.matches("\\d+")) {
                stack.push(item);
                continue;
            }

            int num1 = Integer.parseInt(stack.pop());
            int num2 = Integer.parseInt(stack.pop());

            result = calculate(num1, num2, item);

            stack.push(result + "");
        }

        return Integer.parseInt(stack.pop());
    }

    /**
     * 将中缀表达式转成后缀表达式
     * 1。 初始化两个栈：运算符栈s1和中间结果栈s2
     * 2。 从左至右扫描中缀表达式
     * 3。 遇到操作数，将其压入s2
     * 4。 遇到运算符时，比较其与s1栈顶运算符的优先级
     *      4。1 如果s1为空，或栈顶运算符为左括号"（"，则直接将此运算符入栈
     *      4。2 否则，若优先级比栈顶运算符高，也将运算符压入s1
     *      4。3 否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4。1与s1中新的栈顶运算符相比较
     * 5。 遇到括号：
     *      5。1 如果是左括号"（"，则直接压入s1
     *      5。2 如果是右括号"）"，则依次弹出s1栈顶的操作符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
     * 6。 重复步骤2至5，直到表达式的最右边
     * 7。 将s1剩余的运算符依次弹出并压入s2
     * 8。 依次弹出s2的元素并输出，结果的逆序即为对应的后续表达式
     */
    public List<String> toReversePolishNotation(List<String> list) {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for ( String s : list ) {
            if ( s.matches("\\d+") ) {
                result.add(s);
                continue;
            }

            // 这时候s应该为右括号或者优先级小于栈顶元素
            if ( s.equals(")") ) {
                while ( !stack.peek().equals("(") ) {
                    result.add(stack.pop());
                }

                // 将左边小括号弹出
                stack.pop();
                continue;
            }

            // 这行会匹配到右括号")",优先处理
            if ( stack.isEmpty() || stack.peek().equals("(") || s.equals("(") || priorTo(s, stack.peek()) ) {
                stack.push(s);
                continue;
            }

            while ( stack.size() != 0 && priorTo(stack.peek(), s)) {
                result.add(stack.pop());
            }
            stack.add(s);
        }

        while ( stack.size() != 0 ) {
            result.add(stack.pop());
        }

        return result;
    }

    /**
     * 规则：从左到右遍历中缀表达式的每个数字和符号，若是数字就输出，即成为后缀表达式的一部分；
     * 若是符号，则判断其与栈顶符号的优先级，是右括号或优先级低于栈顶符号（乘除优先加减）则栈顶元素依次出找并输出，
     * 并将当前符号进栈，一直到最终输出后缀表达式为止。
     */
    public List<String> toReversePolishNotation2(List<String> list) {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        String top;

        for ( String s : list ) {
            // 数字直接加入队列
            if ( s.matches("\\d+") ) {
                result.add(s);
                continue;
            }

            if (s.equals(")")) {
                top = stack.pop();
                while (!top.equals("(")) {
                    result.add(top);

                    top = stack.pop();
                }
                continue;
            }

            while ( !stack.isEmpty() && !stack.peek().equals("(") && priorTo(stack.peek(), s) && !s.equals("(") ) {
                result.add(stack.pop());
            }

            stack.push(s);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private boolean priorTo(String o1, String o2) {
        return priority(o1) > priority(o2);
    }

    private static int priority(String c) {
        if (c.equals("+") || c.equals("-")) {
            return 0;
        }

        return 1;
    }

    private int calculate(int num1, int num2, String operation) throws Exception {
        int result;

        switch (operation) {
            case "+":
                result = num2 + num1;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num2 * num1;
                break;
            case "/":
                result = num2 / num1;
                break;
            default:
                throw new Exception("wrong operation");
        }

        return result;
    }
}
