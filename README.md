1. Introduction:
The Logical Calculator program is a Java Swing-based graphical user interface (GUI) application that allows users to perform logical and bitwise operations on numbers in different numeral systems: binary, decimal, and hexadecimal. The program enables users to input numbers, select the desired numeral system, and then apply various logical operations such as AND, OR, XOR, NOT, shift left, and shift right.

2. Program Structure:
The program is structured into several key components, each responsible for different aspects of the calculator's functionality.

Class LogicalCalculator:

Inherits from JFrame to create a window for the calculator.
Implements the ActionListener interface to handle button click events.
GUI Components:

Input Fields:
inputField1: A text field where the first operand is entered.
inputField2: A text field where the second operand is entered.
outputField: A text field where the result is displayed (read-only).
Radix Selection:
binaryButton: A radio button for selecting binary (base-2) input/output.
decimalButton: A radio button for selecting decimal (base-10) input/output.
hexadecimalButton: A radio button for selecting hexadecimal (base-16) input/output.
These buttons are grouped using a ButtonGroup to ensure only one can be selected at a time.
Operation Buttons:
andButton, orButton, xorButton, notButton, shiftLeftButton, shiftRightButton: Buttons for performing the respective logical operations.
Number Buttons:
An array numberButtons that represents the number buttons (0-9) and hexadecimal letters (A-F) for input. The availability of these buttons changes based on the selected numeral system.
Panels:

Input Panel: Contains input fields and radix selection buttons.
Operation Panel: Contains buttons for logical operations.
Number Panel: Contains buttons for numeric and alphabetic inputs.
Event Handling:

All buttons are equipped with action listeners that trigger specific methods based on the operation selected by the user.
3. Workflow:
Initialization:

The LogicalCalculator constructor sets up the GUI, initializes all components, and arranges them within panels that are added to the main frame.
The numeral system is initially set to binary, and only the binary-relevant buttons (0 and 1) are enabled.
User Interaction:

The user inputs numbers in the selected numeral system using the number buttons or directly into the input fields.
The user selects an operation button to perform a logical or bitwise operation on the input(s).
The result of the operation is displayed in the outputField.
Operation Execution:

AND, OR, XOR: These operations take two input numbers, apply the corresponding bitwise operation, and display the result.
NOT: This operation inverts the bits of the first input number.
Shift Left, Shift Right: These operations shift the bits of the first input number left or right by the number of positions specified in the second input field.
4. Code Implementation Details:
setNumberButtonState(int radix):

This method enables or disables the number buttons based on the selected radix (2 for binary, 10 for decimal, 16 for hexadecimal). For example, in binary mode, only the "0" and "1" buttons are enabled.
actionPerformed(ActionEvent e):

This method handles all button click events, determining the source of the event (e.g., a specific button) and executing the corresponding operation method.
getInput(JTextField field):

This helper method retrieves and parses the user input from a text field according to the selected numeral system. If the input is invalid, it defaults to 0.
Logical Operations:

Methods such as performAndOperation, performOrOperation, and performNotOperation carry out specific bitwise operations by converting input strings to long integers, applying the operation, and converting the result back to the selected numeral system for display.
5. Limitations:
User Input Validation:

The program does not provide robust error handling or user feedback for invalid input formats (e.g., entering non-binary digits in binary mode).
Numeric Input:

The calculator relies on text fields for numeric input, which may be less intuitive than a dedicated numeric keypad.
Display Overflow:

The application does not handle cases where the result of an operation exceeds the typical display limits or the data type's range.
6. Conclusion:
The Logical Calculator program is a versatile tool for performing logical and bitwise operations on numbers across different numeral systems. It serves as an educational example of how to implement a basic calculator with a GUI in Java. Future improvements could include enhanced user input validation, additional logical operations, and better error handling.
