
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alex.bujenita
 */
public class Box implements Packable {

    private final ArrayList<Packable> box;
    private final double maxWeight;

    public Box(double maxWeight) {
        this.box = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public void add(Packable item) {
        double futureWeight = this.weight() + item.weight();
        if (futureWeight <= this.maxWeight) {
            this.box.add(item);
        }
    }

    @Override
    public double weight() {
        return this.box.stream().mapToDouble(item -> item.weight()).sum();
    }

    @Override
    public String toString() {
        return "Box: " + this.box.size() + " items, total weight " + this.weight() + " kg";
    }
}
