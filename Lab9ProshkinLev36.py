import AssaultRifle
import sys
def main():
    rifle = AssaultRifle.AssaultRifle("AK-47", "Mechanical Plant")

    while True:
            print("\n--- Rifle Menu ---")
            print("1. Single shot")
            print("2. Shoot")
            print("3. Reload")
            print("4. Check ammo")
            print("5. Change Fire Mode")
            print("6. Check Rifle Status")
            print("7. Clean Rifle")
            print("8. Cool Down Rifle")
            print("9. Check if Rifle is functional")
            print("10. Exit")

            try:
                choice = int(input("Choose an option: "))

                if choice == 1:
                    rifle.shoot()
                elif choice == 2:
                    rifle.shoot_fire_mods()
                elif choice == 3:
                    bullets = int(input("Enter number of bullets to reload: "))
                    rifle.reload(bullets)
                elif choice == 4:
                    rifle.check_ammo()
                elif choice == 5:
                    fire_mode = input("Enter fire mode (e.g., 'Automatic' or 'Single'): ")
                    rifle.change_fire_mode(fire_mode)
                elif choice == 6:
                    rifle.get_info()
                elif choice == 7:
                    rifle.clean()
                elif choice == 8:
                    rifle.cool_down()
                elif choice == 9:
                    rifle.is_functional()
                elif choice == 10:
                    rifle.close()
                    print("Exiting program.")
                    sys.exit()
                else:
                    print("Invalid option. Please choose a number between 1 and 9.")

            except ValueError:
                print("Invalid input. Please enter a valid number.")

            except Exception as e:
                print(f"An error occurred: {e}")

if __name__ == "__main__":
    main()