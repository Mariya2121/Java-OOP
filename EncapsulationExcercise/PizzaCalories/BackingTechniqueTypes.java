package EncapsulationExcercise.PizzaCalories;

public enum BackingTechniqueTypes {
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    public double modifier;

    BackingTechniqueTypes(Double modifier){
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
