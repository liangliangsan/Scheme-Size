package mindustry.ui.dialogs;

import arc.func.*;
import mindustry.ui.*;

import static mindustry.Vars.*;

public class ModUnitSelectDialog extends BaseDialog{

	public Cons<UnitType> callback;

	public ModUnitSelectDialog(){
		super("@unitselect");
		addCloseButton();

		var units = content.units();
		units.each((unit) -> {
			if (unit.isHidden()) return;
			var drawable = new TextureRegionDrawable(unit.icon(Cicon.full));
			cont.button(drawable, () => { 
				callback.get(unit);
				hide(); 
			}).size(64f);
			if (unit.id % 10 == 9) cont.row();
		});
	}

	public void Select(Cons<UnitType> callback){
		this.callback = callback;
		show();
	}
}