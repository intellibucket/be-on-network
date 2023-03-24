package az.rock.flyjob.gateway.locator.handler;

import az.rock.lib.jresponse.response.fail.JFailResponse;

import java.util.Arrays;
import java.util.Objects;

public enum ServerFailPattern {
    UNAUTHORIZED(401) {
        @Override
        public JFailResponse get() {
            return new JFailResponse("Xüsusi icazə tələb edən istək forması aşkarlandı");
        }
    },
    INTERNAL_SERVER_ERROR(500) {
        @Override
        public JFailResponse get() {
            return new JFailResponse("Bir sistem xətası çıxdı :( Ən qısa zamanda həll etməyə çalışacağıq");
        }
    },
    SERVICE_UNAVAILABLE(503) {
        @Override
        public JFailResponse get() {
            return new JFailResponse("Bir sistem xətası çıxdı :( Ən qısa zamanda həll etməyə çalışacağıq");
        }
    },
    BAD_GATEWAY(400) {
        @Override
        public JFailResponse get() {
            return new JFailResponse("Yanlış müraciət forması aşkarlandı");
        }
    };

    private final Integer status;

    ServerFailPattern(Integer status) {
        this.status = status;
    }

    public abstract JFailResponse get();

    public static ServerFailPattern resolve(Integer status) {
        return Arrays.stream(ServerFailPattern.values()).filter(e -> Objects.equals(e.status, status)).findFirst().orElse(ServerFailPattern.BAD_GATEWAY);
    }
}
