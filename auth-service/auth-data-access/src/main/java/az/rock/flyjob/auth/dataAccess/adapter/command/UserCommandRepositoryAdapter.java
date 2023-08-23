package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.UserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.user.UserCommandJPARepository;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.compose.AbstractUserComposeQueryBatisRepository;
import az.rock.flyjob.auth.root.user.UserRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserCommandRepositoryAdapter implements AbstractUserCommandRepositoryAdapter {
    private final UserCommandJPARepository userCommandJPARepository;

    private final AbstractUserComposeQueryBatisRepository userComposeQueryJPARepository;

    private final UserDataAccessMapper userDataAccessMapper;

    public UserCommandRepositoryAdapter(UserCommandJPARepository userCommandJPARepository,
                                        AbstractUserComposeQueryBatisRepository userComposeQueryJPARepository,
                                        UserDataAccessMapper userDataAccessMapper) {
        this.userCommandJPARepository = userCommandJPARepository;
        this.userComposeQueryJPARepository = userComposeQueryJPARepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public Optional<UserRoot> create(UserRoot root) {
        var entity = this.userDataAccessMapper.toNewEntity(root);
        if(entity.isPresent()) {
            //var result = userComposeQueryJPARepository.findUserSimpleComposeByUserId(UUID.fromString("f6cfb6f2-597b-494c-8173-0e1d4157b0bc"));
            var savedEntity = this.userCommandJPARepository.saveAndFlush(entity.get());
            return this.userDataAccessMapper.toRoot(savedEntity);
        }else return Optional.empty();
    }

    @Override
    public void update(UserRoot root) {
        var entity = this.userDataAccessMapper.toEntity(root);
        entity.ifPresent(this.userCommandJPARepository::saveAndFlush);
    }
}
