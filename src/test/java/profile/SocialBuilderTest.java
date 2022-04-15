package profile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocialUrlBuilderTest {

    @Test
    void ShouldCreateSocialUrlIfGivenValidData() {
        SocialUrl youtube = new SocialUrlBuilder().setName("YouTube").setUrl("https://youtube.com/user/relbeits").build();
        assertEquals("YouTube", youtube.getName());
    }

    @Test
    void ShouldNotCreateSocialUrlIfNameIsMissing() {
        assertThrows(IllegalArgumentException.class, () -> new SocialUrlBuilder().setUrl("https://youtube.com/user/relbeits").build());
    }

    @Test
    void ShouldNotCreateSocialUrlIfUrlIsMissing() {
        assertThrows(IllegalArgumentException.class, () -> new SocialUrlBuilder().setName("YouTube").build());
    }

    @Test
    void ShouldNotCreateSocialUrlIfNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new SocialUrlBuilder().setName("").setUrl("https://youtube.com/user/relbeits").build());
    }

    @Test
    void ShouldNotCreateSocialUrlIfUrlIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new SocialUrlBuilder().setName("YouTube").setUrl("").build());
    }

    @Test
    void ShouldNotCreateSocialUrlIfUrlIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new SocialUrlBuilder().setName("YouTube").setUrl("youtube.com/user/relbeits").build());
    }

}