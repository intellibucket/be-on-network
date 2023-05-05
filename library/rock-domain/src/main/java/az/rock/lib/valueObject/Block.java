package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public class Block {
    private final String reason;
    private final BlockType type;

    public Block(String reason, BlockType type) {
        this.reason = reason;
        this.type = type;
    }

    public BlockType getType() {
        return type;
    }

    public String getReason() {
        return reason;
    }


}
