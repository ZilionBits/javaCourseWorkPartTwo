import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;
import itadesign.beerdrinker.NoMoreMaltException;

public class Antarctica implements BeerFactory {
    private double maltReserve = 1.0;

    @Override
    public void receiveMaltShippment(double v) {
        maltReserve += v;
    }

    @Override
    public DefaultBeerBottle produceNextBeerBottle() throws NoMoreMaltException {

        if (maltReserve > 0) {
            maltReserve -= 0.025;
            return new DefaultBeerBottle(0.5, 5.0);
        } else {
        throw new NoMoreMaltException("No more malt");
        }
    }
}
