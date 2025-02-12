package in.sita.sangitaTech.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import in.sita.sangitaTech.dao.UserDao;
import in.sita.sangitaTech.dto.User;

import static org.mockito.Mockito.when;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    public void saveUserTest() {
        // Arrange
        User user = new User();
        user.setId(103);
        user.setName("pihu");

        // Mock the behavior of userDao
        when(userDao.save(user)).thenReturn(true);

        // Act
        boolean actual = userService.saveUser(user);

        // Assert
        assertTrue(actual, "Expected saveUser to return true");
    }
}

