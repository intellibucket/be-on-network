package az.rock.flyjob.auth.dataAccess.model.compose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSimpleCompose {
    private String firstName;
    private String lastName;
}
