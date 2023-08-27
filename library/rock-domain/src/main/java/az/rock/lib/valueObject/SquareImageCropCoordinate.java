package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public class SquareImageCropCoordinate {
    private Integer topLeftAxis;
    private Integer topLeftOrdinate;
    private Integer sideWidth;


    public SquareImageCropCoordinate(Integer topLeftAxis, Integer topLeftOrdinate, Integer sideWidth) {
        this.topLeftAxis = topLeftAxis;
        this.topLeftOrdinate = topLeftOrdinate;
        this.sideWidth = sideWidth;
    }

    public Integer getTopLeftAxis() {
        return topLeftAxis;
    }

    public void setTopLeftAxis(Integer topLeftAxis) {
        this.topLeftAxis = topLeftAxis;
    }

    public Integer getTopLeftOrdinate() {
        return topLeftOrdinate;
    }

    public void setTopLeftOrdinate(Integer topLeftOrdinate) {
        this.topLeftOrdinate = topLeftOrdinate;
    }

    public Integer getSideWidth() {
        return sideWidth;
    }

    public void setSideWidth(Integer sideWidth) {
        this.sideWidth = sideWidth;
    }
}
