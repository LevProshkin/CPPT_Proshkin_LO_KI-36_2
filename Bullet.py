class Bullet:
    def __init__(self, caliber, quantity):
        self.caliber = caliber
        self.quantity = quantity

    def get_caliber(self):
        return self.caliber

    def get_quantity(self):
        return self.quantity

    def use(self):
        if self.quantity > 0:
            self.quantity -= 1

    def add(self, quantity):
        self.quantity += quantity

    def __str__(self):
        return f"Bullet(caliber='{self.caliber}', quantity={self.quantity})"