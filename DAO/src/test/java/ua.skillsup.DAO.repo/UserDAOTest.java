package ua.skillsup.DAO.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.DAO.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @PersistenceContext
    private EntityManager entityManager;


    @Before
    public void cleanUp(){
        System.out.println("CleanUp!");
        entityManager.createQuery("DELETE FROM User u").executeUpdate();
        entityManager.clear();
    }

    @Test
    public void testFindById(){
        //given
        User user = new User("John", "Doe", 10, null);
        entityManager.persist(user);

        //when
        User actualUser = userDAO.get(user.getId());

        //then
        Assert.assertEquals(user, actualUser);
    }


    @Test
    public void testDelete(){
        //given
        User user = new User("John", "Doe", 10, null);
        entityManager.persist(user);
        Long id = user.getId();

        //when
        userDAO.delete(id);

        //then
        entityManager.clear();
        User deletedUser = entityManager.find(User.class,id);
        Assert.assertNull(deletedUser);
    }

    @Test
    public void testUpdate(){
        //given
        User user = new User("John", "Doe", 10, null);
        entityManager.persist(user);
        User newUser = new User("Ivan", "Kozepupka", 12, null);

        //when
        userDAO.update(user.getId(), newUser);

        //then
        User actualUser = entityManager.find(User.class,user.getId());
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testCreate(){
        //given
        User user = new User("John", "Doe", 10, null);

        //when
        userDAO.create(user);

        //then
        User actualUser = entityManager.find(User.class,user.getId());
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testFindAll(){
        //given
        User user = new User("John", "Doe", 10, null);
        User user1 = new User("John1", "Doe1", 11, null);

        List<User> expectedUsers = Arrays.asList(user,user1);
        expectedUsers.forEach(entityManager::persist);

        //when
        List<User> foundUsers = userDAO.findAll();

        //then
        Assert.assertEquals(2, foundUsers.size());
        Assert.assertTrue(foundUsers.containsAll(expectedUsers));
    }
}

