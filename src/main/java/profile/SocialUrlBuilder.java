package profile;

import shared.interfaces.IBuilder;

public class SocialUrlBuilder implements IBuilder<SocialUrl> {
    private SocialUrl instance;

    public SocialUrlBuilder() {
        instance = new SocialUrl();
    }

    public SocialUrl build() {
        if (instance.getUrl().equals("")) {
            throw new IllegalArgumentException("URL não informada");
        }
        if (!instance.getUrl().contains("http://") && !instance.getUrl().contains("https://")) {
            throw new IllegalArgumentException("URL inválida");
        }
        if (instance.getName().equals("")) {
            throw new IllegalArgumentException("Nome não informado");
        }
        return this.instance;
    }

    public SocialUrlBuilder setName(String name) {
        this.instance.setName(name);
        return this;
    }

    public SocialUrlBuilder setUrl(String url) {
        this.instance.setUrl(url);
        return this;
    }
}
