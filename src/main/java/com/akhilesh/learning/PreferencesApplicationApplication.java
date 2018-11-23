package com.akhilesh.learning;

import com.akhilesh.learning.core.UserService;
import com.akhilesh.learning.db.dao.UserDao;
import com.akhilesh.learning.db.entity.UserEntity;
import com.akhilesh.learning.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PreferencesApplicationApplication extends Application<PreferencesApplicationConfiguration> {

    private final HibernateBundle<PreferencesApplicationConfiguration> hibernate =
            new HibernateBundle<PreferencesApplicationConfiguration>(UserEntity.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(PreferencesApplicationConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    public static void main(final String[] args) throws Exception {
        new PreferencesApplicationApplication().run(args);
    }

    @Override
    public String getName() {
        return "PreferencesApplication";
    }

    @Override
    public void initialize(final Bootstrap<PreferencesApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final PreferencesApplicationConfiguration configuration,
                    final Environment environment) {
        final UserDao userDao = new UserDao(hibernate.getSessionFactory());
        UserService userService = new UserService(userDao);
        environment.jersey().register(new UserResource(userService));
    }

}
