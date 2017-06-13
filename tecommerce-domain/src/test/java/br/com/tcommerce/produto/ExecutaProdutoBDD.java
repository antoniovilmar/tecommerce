package br.com.tcommerce.produto;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/business/produto.feature"})
public class ExecutaProdutoBDD {

}
