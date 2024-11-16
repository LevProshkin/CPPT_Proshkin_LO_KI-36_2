import math
import pickle


class ExpressionCalculator:
    """
    Class for calculating the expression y = tan(4x) / x.
    Demonstrates exception handling and logging results.
    """

    def calculate(self, x):
        """
        Calculates the expression y = tan(4x) / x.

        Args:
            x (float): The value of the variable x.

        Returns:
            float: The result of the calculation.

        Raises:
            ValueError: If x is zero, as the expression is undefined.
        """
        if x == 0:
            raise ValueError("The expression is undefined for x = 0.")
        try:
            return math.tan(4 * x) / x
        except Exception as e:
            raise ValueError(f"An error occurred during calculation: {e}")

    def write_to_text_file(self, filename, result):
        """
        Writes the result to a text file.

        Args:
            filename (str): The name of the file to write to.
            result (str): The result to write.
        """
        with open(filename, 'w') as file:
            file.write(result)

    def read_from_text_file(self, filename):
        """
        Reads the result from a text file.

        Args:
            filename (str): The name of the file to read from.

        Returns:
            str: The content of the file.
        """
        with open(filename, 'r') as file:
            return file.read()

    def write_to_binary_file(self, filename, result):
        """
        Writes the result to a binary file.

        Args:
            filename (str): The name of the file to write to.
            result (float): The result to write.
        """
        with open(filename, 'wb') as file:
            pickle.dump(result, file)

    def read_from_binary_file(self, filename):
        """
        Reads the result from a binary file.

        Args:
            filename (str): The name of the file to read from.

        Returns:
            float: The content of the binary file.
        """
        with open(filename, 'rb') as file:
            return pickle.load(file)


def main():
    """
    Main function to run the expression calculation program and test reading and writing methods.
    """
    calculator = ExpressionCalculator()
    while True:
        try:
            x = float(input("Enter a value for x: "))
            result = calculator.calculate(x)
            print(f"The result of the calculation is: {result}")

            # Writing to text file
            text_filename = "calculation_result.txt"
            calculator.write_to_text_file(text_filename, f"The result is: {result}")
            print(f"Result written to text file: {text_filename}")

            # Reading from text file
            text_file_content = calculator.read_from_text_file(text_filename)
            print(f"Content read from text file: {text_file_content}")

            # Writing to binary file
            binary_filename = "calculation_result.bin"
            calculator.write_to_binary_file(binary_filename, result)
            print(f"Result written to binary file: {binary_filename}")

            # Reading from binary file
            binary_file_content = calculator.read_from_binary_file(binary_filename)
            print(f"Content read from binary file: {binary_file_content}")
            break
        except ValueError as e:
            print(f"Error: {e}")
        except Exception as e:
            print(f"Unexpected error: {e}")
            break


if __name__ == "__main__":
    main()
