package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.UserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.user.UserCommandJPARepository;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserCommandRepositoryAdapter implements AbstractUserCommandRepositoryAdapter {
    private final UserCommandJPARepository userCommandJPARepository;
    private final UserDataAccessMapper userDataAccessMapper;

    private final PasswordCommandRepositoryAdapter passwordCommandRepositoryAdapter;

    private final EmailCommandRepositoryAdapter emailCommandRepositoryAdapter;

    private final PhoneNumberCommandRepositoryAdapter phoneNumberCommandRepositoryAdapter;

    private final DetailCommandRepositoryAdapter detailCommandRepositoryAdapter;

    private final AccountPlanCommandRepositoryAdapter accountPlanCommandRepositoryAdapter;

    private final UserSettingsCommandRepositoryAdapter userSettingsCommandRepositoryAdapter;

    public UserCommandRepositoryAdapter(UserCommandJPARepository userCommandJPARepository,
                                        UserDataAccessMapper userDataAccessMapper,
                                        PasswordCommandRepositoryAdapter passwordCommandRepositoryAdapter,
                                        EmailCommandRepositoryAdapter emailCommandRepositoryAdapter,
                                        PhoneNumberCommandRepositoryAdapter phoneNumberCommandRepositoryAdapter,
                                        DetailCommandRepositoryAdapter detailCommandRepositoryAdapter,
                                        AccountPlanCommandRepositoryAdapter accountPlanCommandRepositoryAdapter,
                                        UserSettingsCommandRepositoryAdapter userSettingsCommandRepositoryAdapter) {
        this.userCommandJPARepository = userCommandJPARepository;
        this.userDataAccessMapper = userDataAccessMapper;
        this.passwordCommandRepositoryAdapter = passwordCommandRepositoryAdapter;
        this.emailCommandRepositoryAdapter = emailCommandRepositoryAdapter;
        this.phoneNumberCommandRepositoryAdapter = phoneNumberCommandRepositoryAdapter;
        this.detailCommandRepositoryAdapter = detailCommandRepositoryAdapter;
        this.accountPlanCommandRepositoryAdapter = accountPlanCommandRepositoryAdapter;
        this.userSettingsCommandRepositoryAdapter = userSettingsCommandRepositoryAdapter;
    }

    @Override
    public Optional<UserRoot> create(UserRoot root) {
        var entity = this.userDataAccessMapper.toNewEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.userCommandJPARepository.saveAndFlush(entity.get());
            return this.userDataAccessMapper.toRoot(savedEntity);
        } else return Optional.empty();
    }

    @Override
    public void update(UserRoot root) {
        var entity = this.userDataAccessMapper.toEntity(root);
        entity.ifPresent(this.userCommandJPARepository::saveAndFlush);
    }

    @Override
    public void rollback(UserRoot root) {
        var entity = this.userDataAccessMapper.toEntity(root);
        entity.ifPresentOrElse(
                (userEntity) -> {
                    this.userCommandJPARepository.rollback(userEntity.getUuid());
                    this.passwordCommandRepositoryAdapter.rollback(root.getPasswords());
                    this.emailCommandRepositoryAdapter.rollback(root.getEmails());
                    this.phoneNumberCommandRepositoryAdapter.rollback(root.getPhoneNumbers());
                    this.detailCommandRepositoryAdapter.rollback(root.getDetailRoot());
                    this.accountPlanCommandRepositoryAdapter.rollback(root.getAccountPlans());
                    this.userSettingsCommandRepositoryAdapter.rollback(root.getUserSettingsRoot());
                },
                () -> log.error("User cannot rollback because of entity is null")
        );
    }
}
