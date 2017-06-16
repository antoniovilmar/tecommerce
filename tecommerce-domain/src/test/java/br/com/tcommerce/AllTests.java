package br.com.tcommerce;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.tcommerce.cliente.ExecutaClienteBDD;
import br.com.tcommerce.produto.ExecutaProdutoBDD;

@RunWith(Suite.class)
@SuiteClasses({ExecutaProdutoBDD.class, ExecutaClienteBDD.class})
public class AllTests {
}
