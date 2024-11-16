import Bullet
import Magazine

class Rifle:
    def __init__(self, type, manufacturer, bullet):
        self.type = type
        self.manufacturer = manufacturer
        self.magazine = Magazine.Magazine(40)
        self.bullet = bullet
        self.shots_amount = 0  # Initialize shots amount to 0
        self.cooled = True     # Initially cooled
        self.cleaned = True    # Initially cleaned

    def shoot(self):
        if self.shots_amount >= 50 and not self.cleaned:
            print("Cannot shoot: Rifle needs cleaning!")
            print("You need to clean the rifle before shooting again!")
        elif self.shots_amount >= 20 and not self.cooled:
            print("Cannot shoot: Rifle is too hot and needs cooling!")
            print("Your rifle is too hot and needs to cool down before shooting again!")
        elif self.bullet.get_quantity() > 0:
                self.bullet.use()
                self.shots_amount += 1
                self.cleaned = False
                print(f"Shot fired! Shots amount: {self.shots_amount}")

    def reload(self, quantity):
        """
        Reloads the rifle with a specified quantity of bullets.

        Args:
            quantity (int): The number of bullets to reload.

        Raises:
            ValueError: If the total bullets exceed the magazine's capacity.
        """
        if self.bullet.quantity + quantity <= self.magazine.get_max_amount_of_bullets():
            self.bullet.add(quantity)
            print(f"Reloaded. Total bullets: {self.bullet.get_quantity()}")
        else:
            print("Too many bullets for this magazine.")

    def check_ammo(self):
        """
        Logs the current quantity of bullets.
        """
        print(f"Checked ammo: {self.bullet.get_quantity()}")

    def change_bullet(self, new_bullet):
        """
        Changes the type of bullet used by the rifle.

        Args:
            new_bullet (Bullet): The new bullet to be used.
        """
        self.bullet = new_bullet
        print(f"Bullet changed to: {new_bullet.get_caliber()}")

    def clean(self):
        """
        Cleans the rifle, resetting its cleaned status.
        """
        self.cleaned = True        
        print("Rifle cleaned. Shots amount reset.")

    def get_info(self):
        """
        Prints and logs information about the rifle.
        """
        info = (
            f"{self}\n"
            f"Shots fired: {self.shots_amount}\n"
            f"Cooled down: {self.cooled}\n"
            f"Cleaned: {self.cleaned}"
        )
        print(info)

    def is_functional(self):
        """
        Checks if the rifle is functional.

        Returns:
            bool: True if the rifle is functional, False otherwise.
        """
        functional = self.bullet.get_quantity() < 20 and self.cooled and self.cleaned
        print(f"Functional: {functional}")
        return functional

    def change_fire_mode(self, mode):
        """
        Changes the firing mode of the rifle.

        Args:
            mode (str): The new firing mode (e.g., "Single", "Automatic").
        """
        valid_modes = ["Single", "Automatic", "Burst", "Full load"]
        if mode in valid_modes:
            self.fire_mode = mode
            print(f"Fire mode changed to: {mode}")
        else:
            print(f"Invalid fire mode: {mode}")

    def cool_down(self):
        """
        Cools down the rifle after use.
        """
        self.cooled = True
        print("Rifle cooled down.")

    def __str__(self):
        """
        Returns a string representation of the Rifle instance.

        Returns:
            str: A string representation of the rifle.
        """
        return f"Rifle(type='{self.type}', manufacturer='{self.manufacturer}', bullet={self.bullet})"
    
    def close(self):
        print(f"Rifle(type='{self.type}', manufacturer='{self.manufacturer}', bullet={self.bullet} Shots amount: {self.shots_amount}. Remaining bullets: {self.bullet.get_quantity()}")