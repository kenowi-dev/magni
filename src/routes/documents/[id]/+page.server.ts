import { OUTLINE_TOKEN } from "$env/static/private";
import type { PageServerLoad } from "./$types";

export const load: PageServerLoad = async ({ params }) => {  
    
  const res = await fetch('https://wiki.wittenbude.de/api/documents.info', {
			method: 'POST',
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
        Authorization: `Bearer ${OUTLINE_TOKEN}`
      },
			body: JSON.stringify({
				id: params.id
			})
		})
  
  const data = await res.json();

  data.data.text = data.data.text.replaceAll(/(\[.*\]\()\/api\/attachments\.redirect\?id=(\S*)/g, "$1/documents/attachments/$2");

  console.log(data)
  return {
    document: data
  };
};