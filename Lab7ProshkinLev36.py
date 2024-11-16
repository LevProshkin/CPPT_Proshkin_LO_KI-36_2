def get_side_length():
    """
    Get the size of the square matrix from the user.
    Ensure the input is a positive integer.
    """
    while True:
        try:
            side_length = int(input("Введіть розмір квадратної матриці (додатне число): "))
            if side_length > 0:
                return side_length
            else:
                print("Помилка: розмір матриці повинен бути додатним числом.")
        except ValueError:
            print("Помилка: введіть ціле число.")


def get_filler_symbol():
    """
    Get the filler symbol for the array from the user.
    Ensure the input is exactly one character.
    """
    while True:
        symbol = input("Введіть один символ для заповнення: ")
        if len(symbol) == 1:
            return symbol
        else:
            print("Помилка: введіть лише один символ.")


def generate_jagged_list(side_length, filler_symbol):
    """
    Generate a jagged list with the specified pattern.
    """
    jagged_list = []

    # Add rows for the upper-left triangle
    for i in range(1, side_length // 2 + 1):
        row = filler_symbol * i
        jagged_list.append(row)

    # Add rows for the lower-right triangle
    for i in range(1, side_length // 2 + 1):
        row = ' ' * (side_length // 2) + filler_symbol * i
        jagged_list.append(row)

    return jagged_list


def print_jagged_list(jagged_list):
    """
    Print the jagged list to the console.
    """
    for row in jagged_list:
        print(row)


def write_jagged_list_to_file(jagged_list, file_name="Result.txt"):
    """
    Write the jagged list to a file.
    """
    try:
        with open(file_name, 'w', encoding='utf-8') as file:
            for row in jagged_list:
                file.write(row + '\n')
        print(f"Сформований зубчатий список успішно збережено у файл '{file_name}'.")
    except IOError as e:
        print(f"Помилка запису у файл: {e}")


def main():
    """
    Main function to control the program flow.
    """
    try:
        # Get inputs from the user
        side_length = get_side_length()
        filler_symbol = get_filler_symbol()

        # Generate the jagged list
        jagged_list = generate_jagged_list(side_length, filler_symbol)

        # Print the generated list to console
        print("Сформований зубчатий список:")
        print_jagged_list(jagged_list)

        # Write the generated list to a file
        write_jagged_list_to_file(jagged_list)
    except KeyboardInterrupt:
        print("\nПрограма завершена користувачем.")


if __name__ == "__main__":
    main()
