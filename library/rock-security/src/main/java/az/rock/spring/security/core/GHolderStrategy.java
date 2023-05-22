package az.rock.spring.security.core;

import org.springframework.security.core.context.SecurityContextHolderStrategy;

public enum GHolderStrategy {
    MODE_THREADLOCAL{
        @Override
        protected SecurityContextHolderStrategy strategy() {
            return null;
        }
    }, MODE_INHERITABLETHREADLOCAL{
        @Override
        protected SecurityContextHolderStrategy strategy() {
            return null;
        }
    }, MODE_GLOBAL{
        @Override
        protected SecurityContextHolderStrategy strategy() {
            return null;
        }
    };

    protected abstract SecurityContextHolderStrategy strategy();
}
