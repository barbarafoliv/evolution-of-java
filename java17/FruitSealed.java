public abstract sealed class FruitSealed permits AppleSealed, PearSealed {

    /*
    We use a new keyword 'sealed' to denote that this is a sealed class. We define the classes that can be extended using
    the 'permits' keyword. Any class which extends the sealed class can be either final like PearSealed or can be
    extended by other classes by using the 'non-sealed' keyword when declaring the class as with AppleSealed.

    This implementation would allow AppleSealed to be assigned to FruitSealed class but won't allow any other classes not
    defined by permits keyword to extend FruitSealed class.
    */
}
