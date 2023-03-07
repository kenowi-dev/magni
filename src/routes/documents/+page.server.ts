import { OUTLINE_TOKEN } from "$env/static/private";
import type { PageServerLoad } from "./$types";

export const load: PageServerLoad = async () => {  
  
  const res = await fetch('https://wiki.wittenbude.de/api/collections.info', {
			method: 'POST',
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
        Authorization: `Bearer ${OUTLINE_TOKEN}`
      },
			body: JSON.stringify({
				id: "training-plans-E79NpNWlPg"
			})
		})

    
  return {
    collection: res.json()
  };
};