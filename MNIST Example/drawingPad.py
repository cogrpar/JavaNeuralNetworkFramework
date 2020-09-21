# this class is a drawing pad that can be used to get direct input from the user for the network to predict
from tkinter import *
from PIL import ImageGrab
from PIL import Image

class DrawingPad(object):

    def __init__(self):
        self.root = Tk()

        self.save_button = Button(self.root, text='Done!', command=self.save)
        self.save_button.grid(row=0, column=0)

        self.pad = Canvas(self.root, bg='black', width=280, height=280)
        self.pad.grid(row=1, columnspan=1)

        self.setup()
        self.root.mainloop()

    def setup(self):
        self.old_x = None
        self.old_y = None
        self.pad.bind('<B1-Motion>', self.paint)
        self.pad.bind('<ButtonRelease-1>', self.reset)

    def paint(self, event):
        paint_color = "white"
        if self.old_x and self.old_y:
            self.pad.create_line(self.old_x, self.old_y, event.x, event.y,
                               width=30, fill=paint_color,
                               capstyle=ROUND, smooth=TRUE, splinesteps=36)
        self.old_x = event.x
        self.old_y = event.y

    def reset(self, event):
        self.old_x, self.old_y = None, None

    def save(self):
        print("Saving Drawing...")
        # get the dimensions and position of the window
        x = self.root.winfo_rootx()
        y = self.root.winfo_rooty()
        x1 = x + 280
        y1 = y + 280
        ImageGrab.grab().crop((x, y, x1, y1)).save("./user_drawn_image.png")
        # now that the image has been saved, load it again and downscale it to save it again
        drawing = Image.open("./user_drawn_image.png")
        box = (0, 30, 280, 280) # box to crop the image to
        drawing = drawing.crop(box).resize((28, 28))
        drawing.save("./user_drawn_image_to_scale.png")
        print("Done!")

if __name__ == '__main__':
    DrawingPad()