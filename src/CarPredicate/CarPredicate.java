package CarPredicate;

import Parametrizaçao.Car;
@FunctionalInterface
public interface CarPredicate {
    boolean test(Car car);
    //(parametro) -> <expressao>
    //(Car car)
}
