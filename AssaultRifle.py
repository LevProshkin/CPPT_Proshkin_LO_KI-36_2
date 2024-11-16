from Rifle import Rifle
from Bullet import Bullet

class AssaultRifle(Rifle):
    def __init__(self, type, manufacturer, fire_mode="Single"):
        super().__init__(type, manufacturer, Bullet("7.62mm", 30))
        self.fire_mode = fire_mode
        self.shots_amount = 0
        self.bullet = Bullet("7.62mm", 30)
        

    def shoot_fire_mods(self):
        """
        Shoots the rifle based on the current fire mode and conditions.
        """
        if self.shots_amount >= 50 and not self.cleaned:
            print("You need to clean the rifle before shooting again!")
        elif self.shots_amount >= 20 and not self.cooled:
            print("Your rifle is too hot and needs to cool down before shooting again!")
        elif self.bullet.get_quantity() > 0:
            if self.fire_mode == "Single":
                self.bullet.use()
                self.shots_amount += 1
                self.cleaned = False
                print(f"Shot fired! Shots amount: {self.shots_amount}")
            elif self.fire_mode == "Automatic":
                self.automatic_shoot()
            elif self.fire_mode == "Burst":
                self.burst_shoot()
            elif self.fire_mode == "Full load":
                self.full_load_shoot()
            if self.shots_amount >= 20:
                self.cooled = False

    def automatic_shoot(self):
        """
        Automatic shooting mode: Fires a specified number of shots.
        """
        shots = int(input("Enter the number of shots: "))
        for _ in range(shots):
            if self.bullet.get_quantity() > 0:
                self.bullet.use()
                self.shots_amount += 1
                self.cleaned = False
                print(f"Shots fired! Shots amount: {self.shots_amount}")
            else:
                break

    def burst_shoot(self):
        """
        Burst shooting mode: Fires three bullets in a single burst.
        """
        for _ in range(3):
            if self.bullet.get_quantity() > 0:
                self.bullet.use()
                self.shots_amount += 1
                self.cleaned = False
                print(f"Shots fired! Shots amount: {self.shots_amount}")
            else:
                break

    def full_load_shoot(self):
        """
        Full load shooting mode: Fires all bullets left in the magazine.
        """
        shots_fired = 0
        while self.bullet.get_quantity() > 0:
            self.bullet.use()
            shots_fired += 1
            self.shots_amount += 1
            self.cleaned = False
            print(f"Shots fired! Shots amount: {self.shots_amount}")