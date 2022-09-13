package InterfacesAndAbstractionExcercise.CollectionHierarchy;

public class AddCollection extends Collection implements Addable{

    @Override
    public int add(String element) {
        items.add(element);

        return element.indexOf(element);
    }
}
