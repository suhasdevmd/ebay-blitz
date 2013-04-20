package iiitb.ebay.admin.action;

import iiitb.ebay.admin.service.ManageUserPostService;

public class ManageUserPostAction {
	
	public int[] SellerBlockList;

	public int[] getSellersIDList() {
		return SellerBlockList;
	}

	public void setSellersIDList(int[] sellersIDList) {
		this.SellerBlockList = sellersIDList;
	}
	public String execute(){
		
		System.out.println("In ManageUserPostAction execute method");
		ManageUserPostService mups=new ManageUserPostService();
	
		if(SellerBlockList != null){
			mups.UnblockAllSeller();

		for(int i=0;i<SellerBlockList.length;i++){
			int j=SellerBlockList[i];
			System.out.println("j="+j);
			mups.BlockSeller(j);
			
			
		
		}
		}
		else{
			mups.UnblockAllSeller();
			
		}
	return "SUCCESS";
	}

}
