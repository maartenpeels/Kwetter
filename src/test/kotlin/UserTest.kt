import com.kwetter.models.Tweet
import com.kwetter.models.User
import com.kwetter.services.UserService
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class UserTest {
    @Inject
    lateinit var userService: UserService

    @Before
    fun setUp() {

    }

    @Test
    fun createUsers() {
        var user1 = User("maartenpeels", "maartenpeels@gmal.com", "test", "http://placehold.it/150X150", "Veldhoven, Netherlands", "http://maartenpeels.com")
        var user2 = User("henkpeels", "henkpeels@gmal.com", "test", "http://placehold.it/150X150", "Oirschot, Netherlands", "http://henkpeels.com")

        var tweet1 = Tweet("Eerste tweet ooit!")
        var tweet2 = Tweet("Tweeder tweet ooit!")
        var tweet3 = Tweet("Derde tweet ooit!")
        var tweet4 = Tweet("Vierde tweet ooit!")

        userService.create(user1)
        userService.create(user2)

        assert(userService.getAll().size == 2)
    }
}