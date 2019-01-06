# Advanced-OOP-Project
Advanced OOP Project
Advanced OOP Project Readme.

Student number: G00353180

Github Repository: https://github.com/kevgleeson78/Advanced-OOP-Project
This readme will explain the design decisions taken in refactoring and implementing design patterns to the original application adapted from https://learnonline.gmit.ie/mod/resource/view.php?id=127499.

Refactoring the god Class Gameview.java:
The class GameView.java is responsible for too much functionality breaking the single responsibility rule on numerous occasions throughout the class.
Below is the different methods abstracted out to different interfaces and implementing classes.
Paint component method abstracted out of the GameView class and added to a new class named PaintBoard.
This class is responsible for painting the components of the board within the game view.
This class paints the sprites, tiles and object images and places them to their position within the Isometric view.
This class extends the Isometric class inheriting the conversion to isometric functionality.

##################################################################################

Isometric Interface:
The three methods getIsoY(int x, int y), getIsoX(int x, int y), getIso(int x, int y) were refactored from the god class GameView to an Interface Isometricator.
 The Interface is then implemented by the isometric class. This allows for high cohesion between classes that extend the isometric class. The implementing class Isometric is extended by the GameView Class.

##################################################################################
Interface name: LoadImageable
Abstracted the BufferedImage loadImages method from the god class GameView to an interface to be implemented by the implementing class LoadImages.
The implementing class LoadImages is then extended by the Isometric class creating high cohesion between the two classes.

#################################################################################
Final Refactored GameView class:
Once the GameView class has been refactored it is only responsible for controlling the isometric view, initialising the game view with tiles and player objects and handling key input events.

The builder Design pattern is used to build a spite object within the init() method of this class, see Sprite class explanation.

################################################################################

Matrix Class:
The two matrices of model and objects were abstracted out to the Matrix class with a new instance of the Matrix class created with this class.
This allows for the encapsulation of the two matrices within this class.
IT also promotes the single responsibility principle where this class is now only responsible for holding matrices data. This class can then be reused when needed across the application without relying on the GameWindow class which it was originally designed.

##################################################################################

GameWindow Class with Singleton design pattern:
This class is responsible for creating a singleton instance of the GameWindow class.
The gameWindow single instance is then called in the main method within the runner class.
A private constructor is used to enforce only one instance of the class can be called at any one time.

#################################################################################

Runner class using singleton:
An instance of the singleton GameView is created for the main method originally a new instance of the GameWindow class was instantiated which worked fine but there is nothing stopping the user from creating multiple instances of the GameWindow. 
The singleton design pattern ensures that there can only be one instance of GameView created at any one time.

##################################################################################

Builder design pattern:
The Sprite and SpriteBuilder classes are responsible for holding the data for each sprite within the application.
With: the name of the sprite,
 		The images for the sprite to be animated,
 		The direct the sprite is facing,
 		The index of the sprite image,
 		The current x, y position,
 	 	Moving the sprite.
A builder design pattern is used with this class and the SpriteBuilder class to enable the building (reuse) of custom sprites with different names e.g. player enemy goal objects.

Within the GameView init() method a new sprite is built using the SpriteBuilder create() method.
This allows for multiple creation of different representations of the sprite object with high reusability all from one method.	

##############################################################################	

Moving the Player Character and confining movement to the game grid size:

The move method is used to move the character from one isometric coordinate to another based on the key pressed by the user.
However if the player is continually moved in any direction it will move out of the game view area and past the game gird. 
To fix this problem A new Matrix object is instantiated within the move() method. This ensures that the Matrix object is fully encapsulated. 
The size of the grid can then be used to limit the player’s movement to the game grid. 
With the matrix object dimensions size being used as a value within the move method to limit the player movement it will be bound to this value from the matrix class. 
Therefor the restriction of movement will dynamically change when the matrices dimensions are changed only in the Matrix class.
