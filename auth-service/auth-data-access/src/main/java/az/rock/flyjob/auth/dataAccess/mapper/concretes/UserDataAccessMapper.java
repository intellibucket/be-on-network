package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.detail.DetailEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.*;
import az.rock.flyjob.auth.dataAccess.entity.user.device.DeviceEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.*;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.flyjob.auth.root.user.*;
import az.rock.flyjob.auth.root.user.device.DeviceRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.TimeZoneID;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserDataAccessMapper implements AbstractUserDataAccessMapper<UserEntity, UserRoot> {

    private final AbstractPasswordDataAccessMapper<PasswordEntity, PasswordRoot> passwordDataAccessMapper;

    private final AbstractEmailDataAccessMapper<EmailEntity, EmailRoot> emailDataAccessMapper;

    private final AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> phoneNumberDataAccessMapper;

    private final AbstractDetailDataAccessMapper<DetailEntity, DetailRoot> detailDataAccessMapper;

    private final AbstractAccountPlanDataAccessMapper<AccountPlanEntity, AccountPlanRoot> accountPlanDataAccessMapper;

    private final AbstractDeviceDataAccessMapper<DeviceEntity, DeviceRoot> deviceDataAccessMapper;

    private final AbstractUserSettingsDataAccessMapper<UserSettingsEntity,UserSettingsRoot> userSettingsDataAccessMapper;

    public UserDataAccessMapper(AbstractPasswordDataAccessMapper<PasswordEntity, PasswordRoot> passwordDataAccessMapper,
                                AbstractEmailDataAccessMapper<EmailEntity, EmailRoot> emailDataAccessMapper,
                                AbstractPhoneNumberDataAccessMapper<PhoneNumberEntity, PhoneNumberRoot> phoneNumberDataAccessMapper,
                                AbstractDetailDataAccessMapper<DetailEntity, DetailRoot> detailDataAccessMapper,
                                AbstractAccountPlanDataAccessMapper<AccountPlanEntity, AccountPlanRoot> accountPlanDataAccessMapper,
                                AbstractDeviceDataAccessMapper<DeviceEntity, DeviceRoot> deviceDataAccessMapper,
                                AbstractUserSettingsDataAccessMapper<UserSettingsEntity, UserSettingsRoot> userSettingsDataAccessMapper) {
        this.passwordDataAccessMapper = passwordDataAccessMapper;
        this.emailDataAccessMapper = emailDataAccessMapper;
        this.phoneNumberDataAccessMapper = phoneNumberDataAccessMapper;
        this.detailDataAccessMapper = detailDataAccessMapper;
        this.accountPlanDataAccessMapper = accountPlanDataAccessMapper;
        this.deviceDataAccessMapper = deviceDataAccessMapper;
        this.userSettingsDataAccessMapper = userSettingsDataAccessMapper;
    }

    @Override
    public Optional<UserRoot> toRoot(UserEntity entity) {
        var optionalUserEntity = Optional.ofNullable(entity);
        if (optionalUserEntity.isEmpty()) return Optional.empty();
        return Optional.of(UserRoot.Builder
                .builder()
                .id(UserID.of(entity.getUuid()))
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .rowStatus(entity.getRowStatus())
                .key(entity.getKey())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .username(entity.getUsername())
                .timezone(TimeZoneID.of(entity.getTimezone()))
                .build());
    }

    @Override
    public Optional<UserEntity> toEntity(UserRoot root) {
        var optionalUserRoot = Optional.ofNullable(root);
        if (optionalUserRoot.isEmpty()) return Optional.empty();
        return Optional.of(UserEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .key(root.getKey())
                .firstName(root.getFirstName())
                .lastName(root.getLastName())
                .username(root.getUsername())
                .timezone(root.getTimezone().getValue())
                .build());
    }

    @Override
    public Optional<UserEntity> toNewEntity(UserRoot root) {
        var passwordEntities = root.getPasswords()
                .stream()
                .map(this.passwordDataAccessMapper::toNewEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        var emailEntities = root.getEmails()
                .stream()
                .map(this.emailDataAccessMapper::toNewEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        var phoneNumberEntities = root.getPhoneNumbers()
                .stream()
                .map(this.phoneNumberDataAccessMapper::toNewEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        var detailEntity = this.detailDataAccessMapper
                .toNewEntity(root.getDetailRoot()).orElseThrow(() -> new RuntimeException("Detail not found"));
        var accountPlanEntities = root.getAccountPlans()
                .stream()
                .map(this.accountPlanDataAccessMapper::toNewEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        var deviceEntities = root.getDevices()
                .stream()
                .map(this.deviceDataAccessMapper::toNewEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        var userSettingsEntity = this.userSettingsDataAccessMapper
                .toNewEntity(root.getUserSettingsRoot()).orElseThrow(()-> new RuntimeException("User Settings not found"));
        var userEntity =  UserEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(root.getVersionValue())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .key(root.getKey())
                .firstName(root.getFirstName())
                .lastName(root.getLastName())
                .username(root.getUsername())
                .timezone(root.getTimezone().getValue())
                .passwords(passwordEntities)
                .gender(root.getGender())
                .emails(emailEntities)
                .phoneNumbers(phoneNumberEntities)
                .detail(detailEntity)
                .accountPlans(accountPlanEntities)
                .devices(deviceEntities)
                .settings(userSettingsEntity)
                .build();
        passwordEntities.forEach(passwordEntity -> passwordEntity.setUser(userEntity));
        emailEntities.forEach(emailEntity -> emailEntity.setUser(userEntity));
        phoneNumberEntities.forEach(phoneNumberEntity -> phoneNumberEntity.setUser(userEntity));
        detailEntity.setUser(userEntity);
        accountPlanEntities.forEach(accountPlanEntity -> accountPlanEntity.setUser(userEntity));
        deviceEntities.forEach(deviceEntity -> deviceEntity.setUser(userEntity));
        userSettingsEntity.setUser(userEntity);
        return Optional.of(userEntity);
    }

}

