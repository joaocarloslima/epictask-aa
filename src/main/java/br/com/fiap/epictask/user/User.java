package br.com.fiap.epictask.user;

import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "epictaskuser")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    Long id;
    String name;
    String avatarUrl;
    @Builder.Default
    Integer score = 0;

    public static User convert(OAuth2User principal){
        return new UserBuilder()
                    .id(Long.valueOf(principal.getName()))
                    .name(principal.getAttribute("name"))
                    .avatarUrl(principal.getAttribute("avatar_url"))
                    .build();
    }
    
}
