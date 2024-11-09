import itadesign.beerdrinker.BeerBottle;
import itadesign.beerdrinker.BeerConsumer;

public class Slavic extends BeerConsumer {

    @Override
    protected boolean shouldConsumeBeer(BeerBottle beerBottle) {
        if(beerBottle.getVolumeInLiters() <= 0.5
                && beerBottle.getAlcoholContentInPercent() <= 6.0
                && getBloodAlcoholContentInLiters() <= 0.120) {
        return true;
        }
        return false;
    }

    @Override
    public BeerBottle showBeerBottleToAStranger(BeerBottle beerBottle, boolean b) {
        if(b){
            return new BeerBottle() {
                @Override
                public double getAlcoholContentInPercent() {
                    return 0;
                }

                @Override
                public double getVolumeInLiters() {
                    return beerBottle.getVolumeInLiters();
                }

                @Override
                public void takeASip(double v) {
                    beerBottle.takeASip(v);
                }
            };
        }
        return beerBottle;
    }
}
