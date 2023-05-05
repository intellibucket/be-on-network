package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class GeoMapCoordinate {

    private final BigDecimal west;
    private final BigDecimal south;
    private final BigDecimal east;
    private final BigDecimal north;

    public GeoMapCoordinate(BigDecimal west, BigDecimal south, BigDecimal east, BigDecimal north) {
        this.west = west;
        this.south = south;
        this.east = east;
        this.north = north;
    }

    public BigDecimal getWest() {
        return west;
    }

    public BigDecimal getSouth() {
        return south;
    }

    public BigDecimal getEast() {
        return east;
    }

    public BigDecimal getNorth() {
        return north;
    }
}
