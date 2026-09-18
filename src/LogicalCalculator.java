import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class LogicalCalculator extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    // Constants for the different radixes
    private static final int BINARY = 2;
    private static final int DECIMAL = 10;
    private static final int HEXADECIMAL = 16;

    // GUI components
    private JTextField inputField1;
    private JTextField inputField2;
    private JTextField outputField;
    private JRadioButton binaryButton;
    private JRadioButton decimalButton;
    private JRadioButton hexadecimalButton;
    private JButton andButton;
    private JButton orButton;
    private JButton xorButton;
    private JButton notButton;
    private JButton shiftLeftButton;
    private JButton shiftRightButton;
    private JButton[] numberButtons;

    public LogicalCalculator() {
        // Set up the frame
        setTitle("Logical Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create the input fields
        inputField1 = new JTextField(20);
        inputField2 = new JTextField(20);
        outputField = new JTextField(20);
        outputField.setEditable(false);

        // Create the radio buttons for selecting the radix
        binaryButton = new JRadioButton("Binary", true);
        decimalButton = new JRadioButton("Decimal");
        hexadecimalButton = new JRadioButton("Hexadecimal");
        ButtonGroup radixGroup = new ButtonGroup();
        radixGroup.add(binaryButton);
        radixGroup.add(decimalButton);
        radixGroup.add(hexadecimalButton);

        // Create the buttons for the logical operations
        andButton = new JButton("And");
        orButton = new JButton("Or");
        xorButton = new JButton("Xor");
        notButton = new JButton("Not");
        shiftLeftButton = new JButton("Shift Left");
        shiftRightButton = new JButton("Shift Right");

        // Create the number buttons
        numberButtons = new JButton[16];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }
        numberButtons[10] = new JButton("A");
        numberButtons[11] = new JButton("B");
        numberButtons[12] = new JButton("C");
        numberButtons[13] = new JButton("D");
        numberButtons[14] = new JButton("E");
        numberButtons[15] = new JButton("F");

// Create a panel for the input fields and radio buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input 1:"));
        inputPanel.add(inputField1);
        inputPanel.add(new JLabel("Input 2:"));
        inputPanel.add(inputField2);
        inputPanel.add(new JLabel("Output:"));
        inputPanel.add(outputField);
        inputPanel.add(binaryButton);
        inputPanel.add(decimalButton);
        inputPanel.add(hexadecimalButton);

// Create a panel for the logical operation buttons
        JPanel operationPanel = new JPanel();
        operationPanel.add(andButton);
        operationPanel.add(orButton);
        operationPanel.add(xorButton);
        operationPanel.add(notButton);
        operationPanel.add(shiftLeftButton);
        operationPanel.add(shiftRightButton);

// Create a panel for the number buttons
        JPanel numberPanel = new JPanel();
        for (int i = 0; i < numberButtons.length; i++) {
            numberPanel.add(numberButtons[i]);
        }

// Add the panels to the frame
        add(inputPanel);
        add(operationPanel);
        add(numberPanel);

// Add action listeners to the buttons
        binaryButton.addActionListener(this);
        decimalButton.addActionListener(this);
        hexadecimalButton.addActionListener(this);
        andButton.addActionListener(this);
        orButton.addActionListener(this);
        xorButton.addActionListener(this);
        notButton.addActionListener(this);
        shiftLeftButton.addActionListener(this);
        shiftRightButton.addActionListener(this);
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i].addActionListener(this);
        }

// Set the initial state of the number buttons
        setNumberButtonState(BINARY);
    }

    private void setNumberButtonState(int radix) {
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i].setEnabled(i < radix);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == binaryButton) {
            setNumberButtonState(BINARY);
        } else if (source == decimalButton) {
            setNumberButtonState(DECIMAL);
        } else if (source == hexadecimalButton) {
            setNumberButtonState(HEXADECIMAL);
        } else if (source == andButton) {
            performAndOperation();
        } else if (source == orButton) {
            performOrOperation();
        } else if (source == xorButton) {
            performXorOperation();
        } else if (source == notButton) {
            performNotOperation();
        } else if (source == shiftLeftButton) {
            performShiftLeftOperation();
        } else if (source == shiftRightButton) {
            performShiftRightOperation();
        } //else {
        //for (int i = 0;
    }
    private void performAndOperation () {
        long input1 = getInput1();
        long input2 = getInput2();
        long result = input1 & input2;
        outputField.setText(Long.toString(result, getSelectedRadix()));
    }

    private void performOrOperation () {
        long input1 = getInput1();
        long input2 = getInput2();
        long result = input1 | input2;
        outputField.setText(Long.toString(result, getSelectedRadix()));
    }

    private void performXorOperation () {
        long input1 = getInput1();
        long input2 = getInput2();
        long result = input1 ^ input2;
        outputField.setText(Long.toString(result, getSelectedRadix()));
    }

    private void performNotOperation () {
        long input = getInput1();
        long result = ~input;
        outputField.setText(Long.toString(result, getSelectedRadix()));
    }

    private void performShiftLeftOperation () {
        long input1 = getInput1();
        long input2 = getInput2();
        long result = input1 << input2;
        outputField.setText(Long.toString(result, getSelectedRadix()));
    }

    private void performShiftRightOperation () {
        long input1 = getInput1();
        long input2 = getInput2();
        long result = input1 >> input2;
        outputField.setText(Long.toString(result, getSelectedRadix()));
    }

    private long getInput1 () {
        return getInput(inputField1);
    }

    private long getInput2 () {
        return getInput(inputField2);
    }

    private long getInput (JTextField field){
        try {
            return Long.parseLong(field.getText(), getSelectedRadix());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int getSelectedRadix () {
        if (binaryButton.isSelected()) {
            return BINARY;
        } else if (decimalButton.isSelected()) {
            return DECIMAL;
        } else {
            return HEXADECIMAL;
        }
    }

    public static void main (String[] args){
        LogicalCalculator calculator = new LogicalCalculator();
        calculator.setVisible(true);
    }
}

