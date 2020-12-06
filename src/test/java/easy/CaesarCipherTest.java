package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherTest {

	private final CaesarCipher caesarCipher = new CaesarCipher();

	private final BiFunction<String, Integer, String> solver = caesarCipher::solve;

	@MethodSource
	@ParameterizedTest
	void test(String text, int rotationFactor, String encryptedText) {
		assertEquals(encryptedText, solver.apply(text, rotationFactor));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("text", 0, "text"),
			Arguments.of("z=Z", 26, "z=Z"),
			Arguments.of("middle-Outz", 2, "okffng-Qwvb"),
			Arguments.of("Always-Look-on-the-Bright-Side-of-Life", 5, "Fqbfdx-Qttp-ts-ymj-Gwnlmy-Xnij-tk-Qnkj"),
			Arguments.of("!m-rB`-oN!.W`cLAcVbN/CqSoolII!SImji.!w/`Xu`uZa1TWPRq`uRBtok`xPT`lL-zPTc.BSRIhu..-!.!tcl!-U",
				62, "!w-bL`-yX!.G`mVKmFlX/MaCyyvSS!CSwts.!g/`He`eJk1DGZBa`eBLdyu`hZD`vV-jZDm.LCBSre..-!.!dmv!-E")
		);
	}

}