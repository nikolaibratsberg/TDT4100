package patterns.observable;

import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;
import patterns.observable.Stock;
import patterns.observable.StockIndex;

@JExercise(description = "Tests patterns.observable.StockIndex")
@SuppressWarnings("all")
public class StockIndexTest extends TestCase {
  private Stock facebook;
  
  private Stock _init_facebook() {
    Stock _stock = new Stock("FB", 67.80);
    return _stock;
  }
  
  private Stock apple;
  
  private Stock _init_apple() {
    Stock _stock = new Stock("AAPL", 534.98);
    return _stock;
  }
  
  private StockIndex emptyIndex;
  
  private StockIndex _init_emptyIndex() {
    StockIndex _stockIndex = new StockIndex("OSEBX");
    return _stockIndex;
  }
  
  private StockIndex oneIndex;
  
  private StockIndex _init_oneIndex() {
    StockIndex _stockIndex = new StockIndex("OSEBX", this.facebook);
    return _stockIndex;
  }
  
  private StockIndex severalIndex;
  
  private StockIndex _init_severalIndex() {
    StockIndex _stockIndex = new StockIndex("OSEBX", this.facebook, this.apple);
    return _stockIndex;
  }
  
  @Override
  protected void setUp() {
    facebook = _init_facebook();
    apple = _init_apple();
    emptyIndex = _init_emptyIndex();
    oneIndex = _init_oneIndex();
    severalIndex = _init_severalIndex();
    
  }
  
  private boolean operator_equals(final double n1, final double n2) {
    boolean _xblockexpression = false;
    {
      final double epsilon = 0.0000001;
      boolean _and = false;
      double _minus = (n1 - epsilon);
      boolean _lessEqualsThan = (_minus <= n2);
      if (!_lessEqualsThan) {
        _and = false;
      } else {
        double _plus = (n1 + epsilon);
        boolean _greaterEqualsThan = (_plus >= n2);
        _and = (_lessEqualsThan && _greaterEqualsThan);
      }
      _xblockexpression = (_and);
    }
    return _xblockexpression;
  }
  
  @JExercise(tests = "StockIndex(String,patterns.observable.Stock[])", description = "<h3>Tests constructor with no Stock-objects as argument</h3>Tests \n\t\tinitialization\n")
  public void testConstructorEmpty() {
    _test__constructorEmpty_transitions0_effect_state();
    
  }
  
  @JExercise(tests = "StockIndex(String,patterns.observable.Stock[])", description = "<h3>Tests constructor with a single Stock-object as argument</h3>Tests \n\t\tinitialization\n")
  public void testConstructorOne() {
    _test__constructorOne_transitions0_effect_state();
    
  }
  
  @JExercise(tests = "StockIndex(String,patterns.observable.Stock[])", description = "<h3>Tests constructor with several Stock-objects as argument</h3>Tests \n\t\tinitialization\n")
  public void testConstructorSeveral() {
    _test__constructorSeveral_transitions0_effect_state();
    
  }
  
  @JExercise(tests = "StockIndex(String,patterns.observable.Stock[]);void addStock(patterns.observable.Stock)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>emptyIndex.addStock(facebook)</li>\n\t\t<li>emptyIndex.addStock(facebook)</li>\n\t\t</ul>\n")
  public void testAddStock() {
    _transition_exprAction__addStock_transitions0_actions0();
    _test__addStock_transitions0_effect_state();
    _transition_exprAction__addStock_transitions1_actions0();
    _test__addStock_transitions1_effect_state();
    
  }
  
  @JExercise(tests = "StockIndex(String,patterns.observable.Stock[]);void removeStock(patterns.observable.Stock)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>severalIndex.removeStock(apple)</li>\n\t\t<li>severalIndex.removeStock(apple)</li>\n\t\t</ul>\n")
  public void testRemoveStock() {
    _transition_exprAction__removeStock_transitions0_actions0();
    _test__removeStock_transitions0_effect_state();
    _transition_exprAction__removeStock_transitions1_actions0();
    _test__removeStock_transitions1_effect_state();
    
  }
  
  @JExercise(tests = "StockIndex(String,patterns.observable.Stock[])", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>facebook.setPrice(67.0)</li>\n\t\t<li>facebook.setPrice(69.0)</li>\n\t\t</ul>\n")
  public void testChangePrice() {
    _transition_exprAction__changePrice_transitions0_actions0();
    _test__changePrice_transitions0_effect_state();
    _transition_exprAction__changePrice_transitions1_actions0();
    _test__changePrice_transitions1_effect_state();
    
  }
  
  private void _test__constructorEmpty_transitions0_effect_state() {
    _test__constructorEmpty_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__constructorEmpty_transitions0_effect_state_objectTests0_test() {
    
    double _index = this.emptyIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 0.0);
    assertTrue("emptyIndex.getIndex() == 0.0 failed", _equals);
    
  }
  
  private void _test__constructorOne_transitions0_effect_state() {
    _test__constructorOne_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__constructorOne_transitions0_effect_state_objectTests0_test() {
    
    double _index = this.oneIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 67.80);
    assertTrue("oneIndex.getIndex() == 67.80 failed", _equals);
    
  }
  
  private void _test__constructorSeveral_transitions0_effect_state() {
    _test__constructorSeveral_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__constructorSeveral_transitions0_effect_state_objectTests0_test() {
    
    double _index = this.severalIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 602.78);
    assertTrue("severalIndex.getIndex() == 602.78 failed", _equals);
    
  }
  
  private void _transition_exprAction__addStock_transitions0_actions0() {
    try {
      
      this.emptyIndex.addStock(this.facebook);
      } catch (junit.framework.AssertionFailedError error) {
      fail("emptyIndex.addStock(facebook) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__addStock_transitions0_effect_state() {
    _test__addStock_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__addStock_transitions0_effect_state_objectTests0_test() {
    
    double _index = this.emptyIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 67.8);
    assertTrue("emptyIndex.getIndex() == 67.8 failed after emptyIndex.addStock(facebook)", _equals);
    
  }
  
  private void _transition_exprAction__addStock_transitions1_actions0() {
    try {
      
      this.emptyIndex.addStock(this.facebook);
      } catch (junit.framework.AssertionFailedError error) {
      fail("emptyIndex.addStock(facebook) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__addStock_transitions1_effect_state() {
    _test__addStock_transitions1_effect_state_objectTests0_test();
    
  }
  
  private void _test__addStock_transitions1_effect_state_objectTests0_test() {
    
    double _index = this.emptyIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 67.8);
    assertTrue("emptyIndex.getIndex() == 67.8 failed after emptyIndex.addStock(facebook)", _equals);
    
  }
  
  private void _transition_exprAction__removeStock_transitions0_actions0() {
    try {
      
      this.severalIndex.removeStock(this.apple);
      } catch (junit.framework.AssertionFailedError error) {
      fail("severalIndex.removeStock(apple) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__removeStock_transitions0_effect_state() {
    _test__removeStock_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__removeStock_transitions0_effect_state_objectTests0_test() {
    
    double _index = this.severalIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 67.8);
    assertTrue("severalIndex.getIndex() == 67.8 failed after severalIndex.removeStock(apple)", _equals);
    
  }
  
  private void _transition_exprAction__removeStock_transitions1_actions0() {
    try {
      
      this.severalIndex.removeStock(this.apple);
      } catch (junit.framework.AssertionFailedError error) {
      fail("severalIndex.removeStock(apple) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__removeStock_transitions1_effect_state() {
    _test__removeStock_transitions1_effect_state_objectTests0_test();
    
  }
  
  private void _test__removeStock_transitions1_effect_state_objectTests0_test() {
    
    double _index = this.severalIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 67.8);
    assertTrue("severalIndex.getIndex() == 67.8 failed after severalIndex.removeStock(apple)", _equals);
    
  }
  
  private void _transition_exprAction__changePrice_transitions0_actions0() {
    try {
      
      this.facebook.setPrice(67.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("facebook.setPrice(67.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__changePrice_transitions0_effect_state() {
    _test__changePrice_transitions0_effect_state_objectTests0_test();
    
  }
  
  private void _test__changePrice_transitions0_effect_state_objectTests0_test() {
    
    double _index = this.severalIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 601.98);
    assertTrue("severalIndex.getIndex() == 601.98 failed after facebook.setPrice(67.0)", _equals);
    
  }
  
  private void _transition_exprAction__changePrice_transitions1_actions0() {
    try {
      
      this.facebook.setPrice(69.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("facebook.setPrice(69.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__changePrice_transitions1_effect_state() {
    _test__changePrice_transitions1_effect_state_objectTests0_test();
    
  }
  
  private void _test__changePrice_transitions1_effect_state_objectTests0_test() {
    
    double _index = this.severalIndex.getIndex();
    boolean _equals = this.operator_equals(_index, 603.98);
    assertTrue("severalIndex.getIndex() == 603.98 failed after facebook.setPrice(69.0)", _equals);
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(StockIndexTest.class);
  }
}
