package az.rock.flyjob.auth.dataAccess.repository.concretes.query.jooq;

import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Users;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.jooq.AbstractUserJOOQRepository;
import org.jooq.DSLContext;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserJOOQRepository implements AbstractUserJOOQRepository {

    private final DSLContext dslContext;

    public UserJOOQRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public Users findUserById(UUID uuid) {
        var resultSet = this.dslContext
                .select()
                .from(Users.USERS)
                .where(Users.USERS.UUİD.eq(uuid))
                .fetch()
                .intoResultSet();
        return null;
    }
}
