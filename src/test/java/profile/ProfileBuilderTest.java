package profile;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shared.utils.FormatDate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfileBuilderTest {
    static ArrayList<SocialUrl> socialUrls;

    @BeforeAll
    static void setup() {
        socialUrls = new ArrayList<>();
        socialUrls.add(new SocialUrlBuilder().setName("GitHub").setUrl("https://github.com/euaaron").build());
        socialUrls.add(new SocialUrlBuilder().setName("LinkedIn").setUrl("https://linkedin.com/in/aaron-carneiro").build());
        socialUrls.add(new SocialUrlBuilder().setName("Rocketseat").setUrl("https://app.rocketseat.com.br/me/aaron").build());
        socialUrls.add(new SocialUrlBuilder().setName("YouTube").setUrl("https://youtube.com/user/relbeits").build());
        socialUrls.add(new SocialUrlBuilder().setName("Twitch").setUrl("https://www.twitch.tv/relbeits").build());
    }

    @Test
    void ProfileShouldBeCreatedIfGivenValidData() {
        assertDoesNotThrow(
                () -> new ProfileBuilder().setUsername("euaaron")
                        .setName("Aaron Carneiro")
                        .setBirthDate("18/08/1996")
                        .setEmail("hello@aaroncarneiro.com")
                        .setSocialProfiles(socialUrls)
                        .build()
        );
    }

    @Test
    void ProfileShouldNotBeCreatedIfNotGivenAnyMandatoryData() {
        try {
            new ProfileBuilder().build();
            fail();
        } catch (Exception e) {
            assertEquals("Usuário não informado", e.getMessage());
        }
    }

    @Test
    void EmailShouldNotBeEmpty() {
        try {
            new ProfileBuilder().setUsername("euaaron")
                    .setName("Aaron Carneiro")
                    .setBirthDate("18/08/1996")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Email inválido", e.getMessage());
        }
    }

    @Test
    void NameShouldBeProvided() {
        try {
            new ProfileBuilder().setUsername("euaaron")
                    .setBirthDate("18/08/1996")
                    .setEmail("hello@aaroncarneiro.com")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Nome não informado", e.getMessage());
        }
    }

    @Test
    void NameShouldNotBeEmpty() {
        try {
            new ProfileBuilder().setUsername("euaaron")
                    .setName("")
                    .setBirthDate("18/08/1996")
                    .setEmail("hello@aaroncarneiro.com")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Nome não informado", e.getMessage());
        }
    }

    @Test
    void NameShouldNotContainNumbers() {
        try {
            new ProfileBuilder().setUsername("euaaron")
                    .setName("Aaron C4rne1r0")
                    .setBirthDate("18/08/1996")
                    .setEmail("hello@aaroncarneiro.com")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Nome não pode conter números", e.getMessage());
        }
    }

    @Test
    void NameShouldHaveMoreThan3Characters() {
        try {
            new ProfileBuilder().setUsername("euaaron")
                    .setName("An")
                    .setBirthDate("42/13/1896")
                    .setEmail("hello@anonymous.tech")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void UsernameShouldBeProvided() {
        try {
            new ProfileBuilder().setName("Aaron Carneiro")
                    .setBirthDate("18/08/1996")
                    .setEmail("hello@aaroncarneiro.com")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Usuário não informado", e.getMessage());
        }
    }

    @Test
    void UsernameShouldNotBeEmpty() {
        try {
            new ProfileBuilder().setUsername("")
                    .setName("Aaron Carneiro")
                    .setBirthDate("18/08/1996")
                    .setEmail("hello@aaroncarneiro.com")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Usuário não informado", e.getMessage());
        }
    }

    @Test
    void BirthDateShouldBeProvided() {
        try {
            new ProfileBuilder().setUsername("euaaron")
                    .setName("Aaron Carneiro")
                    .setEmail("hello@aaroncarneiro.com")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Data de Nascimento não informada", e.getMessage());
        }
    }

    @Test
    void BirthDateShouldBeMoreThan12YearsOld() {
        try {
            new ProfileBuilder().setUsername("euaaron")
                    .setName("Aaron Carneiro")
                    .setBirthDate("18/08/2022")
                    .setEmail("hello@aaroncarneiro.com")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Data de Nascimento inválida", e.getMessage());
        }
    }

    @Test
    void BirthDateDayShouldBeBetween1And31() {
        try {
            new ProfileBuilder().setUsername("anonym")
                    .setName("Anon")
                    .setBirthDate("42/12/2006")
                    .setEmail("hello@anonymous.tech")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Data de Nascimento inválida", e.getMessage());
        }
    }

    @Test
    void BirthDateMonthShouldBeBetween1and12() {
        try {
            new ProfileBuilder().setUsername("anonym")
                    .setName("Anon")
                    .setBirthDate("23/00/2006")
                    .setEmail("hello@anonymous.tech")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Data de Nascimento inválida", e.getMessage());
        }
    }

    @Test
    void BirthDateYearShouldNotBeInTheFuture() {
        try {
            new ProfileBuilder().setUsername("anonym")
                    .setName("Anon")
                    .setBirthDate("23/06/3020")
                    .setEmail("hello@anonymous.tech")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Data de Nascimento inválida", e.getMessage());
        }
    }

    @Test
    void BirthDateYearShouldNotBeMoreThan150Years() {
        try {
            new ProfileBuilder().setUsername("anonym")
                    .setName("Anon")
                    .setBirthDate("23/06/1020")
                    .setEmail("hello@anonymous.tech")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Data de Nascimento inválida", e.getMessage());
        }
    }

    @Test
    void BirthDateYearShouldBeFormattedAsDDMMYYYY() {
        try {
            new ProfileBuilder().setUsername("anonym")
                    .setName("Anon")
                    .setBirthDate("23/AGO/2000")
                    .setEmail("hello@anonymous.tech")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Data de Nascimento inválida", e.getMessage());
        }
    }

    @Test
    void PhoneNumberShouldNotHaveLetters() {
        try {
            new ProfileBuilder().setUsername("anonym")
                    .setName("Anon")
                    .setBirthDate("23/06/2000")
                    .setEmail("hello@anonymous.tech")
                    .setPhoneNumber("BR(11)991234567")
                    .build();
            fail();
        } catch (Exception e) {
            assertEquals("Telefone inválido", e.getMessage());
        }
    }

    @Test
    void PhoneNumberShouldBeValid() {
        Profile user = new ProfileBuilder().setUsername("anonym")
                .setName("Anon")
                .setBirthDate("23/06/2000")
                .setEmail("hello@anonymous.tech")
                .setPhoneNumber("+5511991234567")
                .build();
        assertEquals("+5511991234567", user.getPhoneNumber());
    }

    @Test
    void SocialProfilesShouldNeverBeNull() {
        Profile user = new ProfileBuilder().setUsername("anonym")
                .setName("Anon")
                .setBirthDate("23/06/2000")
                .setEmail("hello@anonymous.tech")
                .setPhoneNumber("+5511991234567")
                .build();
        assertEquals(0, user.getSocialUrls().size());
    }

    @Test
    void CreatedAtShouldBeCreatedWhenBuildProfile() {
        String currentDate = FormatDate.now();
        Profile user = new ProfileBuilder().setUsername("euaaron")
                .setName("Aaron Carneiro")
                .setBirthDate("18/08/1996")
                .setEmail("hello@aaroncarneiro.com")
                .build();
        assertEquals(currentDate, user.getCreatedAt());
    }

    @Test
    void UpdatedAtMustBeUpdatedAfterChangingValues() {
        String currentDate = FormatDate.now();
        Profile user = new ProfileBuilder().setUsername("euaaron")
                .setName("Aaron Carneiro")
                .setBirthDate("18/08/1996")
                .setEmail("hello@aaroncarneiro.com")
                .build();
        user.setEmail("github@aaroncarneiro.com");
        assertEquals(currentDate, user.getUpdatedAt());
    }

    @Test
    void IDShouldBeGeneratedWhenBuildProfile() {
        Profile user = new ProfileBuilder().setUsername("euaaron")
                .setName("Aaron Carneiro")
                .setBirthDate("18/08/1996")
                .setEmail("hello@aaroncarneiro.com")
                .build();
        assertNotNull(user.getId());
    }

    @Test
    void ShouldBeAbleToAddSocialProfile() {
        Profile user = new ProfileBuilder().setUsername("euaaron")
                .setName("Aaron Carneiro")
                .setBirthDate("18/08/1996")
                .setEmail("hello@aaroncarneiro.com")
                .build();
        user.addSocialUrl(new SocialUrlBuilder().setName("github").setUrl("https://github.com/euaaron").build());
        assertEquals(1, user.getSocialUrls().size());
    }

}