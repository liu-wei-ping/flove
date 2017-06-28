package yay.lv.wp.action.login;

import java.text.SimpleDateFormat;

import org.junit.Test;

public class LoginActionTest {

	public static SimpleDateFormat df = new SimpleDateFormat(
			"YYYY-MM-DD HH:ss:mm:SSS");
	public static long end = 1999999999;
	public static long start = 2;

	@Test
	public void test() {
		final long st = System.currentTimeMillis();
		long total = 0;
		for (long i = start, j = end; i <= end; i++, j--) {
			total = total + i + j;
		}
		System.out.println(total / 2);
		final long ed = System.currentTimeMillis();
		System.out.println("耗时...." + (ed - st));
	}

	@Test
	public void test0() {
		final long st = System.currentTimeMillis();
		long total = 0;
		long count = 0;
		for (long i = 1, j = (start + end); i <= (count = (end % 2 == 0 ? end / 2
				: end / 2 + 1)); i++) {
			if (end % 2 != 0 && i == count) {
				total = total + j / 2;
			} else {
				total = total + j;
			}
		}
		System.out.println(total);
		final long ed = System.currentTimeMillis();
		System.out.println("耗时...." + (ed - st));
	}

	@Test
	public void test1() {
		final long st = System.currentTimeMillis();
		final long total = (end + start) * end / 2;
		System.out.println(total);
		final long ed = System.currentTimeMillis();
		System.out.println("耗时...." + (ed - st));
	}
}
