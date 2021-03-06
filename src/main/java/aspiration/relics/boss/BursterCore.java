package aspiration.relics.boss;

import aspiration.relics.abstracts.AspirationRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.CrackedCore;

public class BursterCore extends AspirationRelic {
    public static final String ID = "aspiration:BursterCore";

    public static final int EVOKE_AMT = 2;

    public BursterCore() {
        super(ID, "BursterCore.png", RelicTier.BOSS, LandingSound.CLINK);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[1] + DESCRIPTIONS[0];
    }

    @Override
    public void onEquip() {
        this.description = getUpdatedDescription();
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, DESCRIPTIONS[0]));
        this.initializeTips();
    }

    //Actual logic is in BursterCorePatch

    @Override
    public boolean canSpawn() {
        return AbstractDungeon.player.hasRelic(CrackedCore.ID) && !AbstractDungeon.player.hasRelic(Stellarator.ID);
    }

    public AbstractRelic makeCopy() {
        return new BursterCore();
    }
    
    /*@Override
	public void obtain() {
		if (AbstractDungeon.player.hasRelic(CrackedCore.ID)) {
			 for (int i = 0; i < AbstractDungeon.player.relics.size(); ++i) {
	                if (AbstractDungeon.player.relics.get(i).relicId.equals(CrackedCore.ID)) {
	                    instantObtain(AbstractDungeon.player, i, true);
	                    break;
	                }
			 }
		}
		else {
			super.obtain();
		}
	}
    
    @Override
    public void onPlayerEndTurn()
    {
    	if(((GameActionManager.turn) % TURN_INTERVAL) == 0) {
    		channelToFull();
    		startingCharges();
    	} else {
    		flash();
    		manipCharge(1);
    	}
    }
    
    private void channelToFull()
    {
    	AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    	
    	if (AbstractDungeon.player.hasEmptyOrb())
		{
			int channel_amount = AbstractDungeon.player.maxOrbs - AbstractDungeon.player.filledOrbCount();
			
			AbstractDungeon.actionManager.addToBottom(new SFXAction("THUNDERCLAP"));
			AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			for(int i = 0;i<channel_amount;i++)
			{
				AbstractDungeon.player.channelOrb(new Lightning());
			}
		}
    }
    
    private void startingCharges()
    {
        setCounter(START_CHARGE);
    }
    
    private void manipCharge(int amt) {
        if (counter < 0) {
            counter = 0;
        }
        setCounter(counter + amt);
    }*/
}
