import { OUTLINE_TOKEN } from "$env/static/private";
import { redirect } from "@sveltejs/kit";
import type { RequestHandler } from "./$types";


export const GET: RequestHandler = async ({ params }) => {

  const res = await fetch('https://wiki.wittenbude.de/api/attachments.redirect', {
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

  const json = await res.blob();
  console.log(json);
    
  return new Response(json);
}
